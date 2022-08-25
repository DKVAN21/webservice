using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Identity;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using lib;
using Microsoft.EntityFrameworkCore;
using lib.Repositories;
using lib.Services;

namespace APISHOPSENDA
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddTransient<IGIOHANGRepository, GIOHANGRepository>();
            services.AddTransient<GIOHANGServices>();

            services.AddTransient<IKHACHHANGRepository, KHACHHANGRepository>();
            services.AddTransient<KHACHHANGServices>();

            services.AddTransient<INHANVIENRepository, NHANVIENRepository>();
            services.AddTransient<NHANVIENServices>();

            services.AddTransient<ILOAISPRepository, LOAISPRepository>();
            services.AddTransient<LOAISPServices>();

            services.AddTransient<ISANPHAMRepository, SANPHAMRepository>();
            services.AddTransient<SANPHAMServices>();

            services.AddTransient<IHOADONRepository, HOADONRepository>();
            services.AddTransient<HOADONServices>();

            services.AddSingleton<ApplicationDbContext>();
            services.AddDbContext<ApplicationDbContext>(options => options.UseSqlServer(Configuration.GetConnectionString("DefaultConnection")), ServiceLifetime.Singleton);
            services.AddIdentity<ApplicationUser, IdentityRole>(options => options.SignIn.RequireConfirmedEmail = false)
               .AddEntityFrameworkStores<ApplicationDbContext>()
               .AddDefaultTokenProviders();
            services.AddControllersWithViews();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }
            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=Home}/{action=Index}/{id?}");
            });
        }
    }
}
