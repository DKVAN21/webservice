
using lib.Entity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib
{
     public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public DbSet<NHANVIEN> NHANVIEN { get; set; }
        public DbSet<KHACHHANG> KHACHHANG { get; set; }
        public DbSet<HOADON> HOADON { get; set; }
        public DbSet<GIOHANG> GIOHANG { get; set; }
        public DbSet<LOAISP> LOAISP { get; set; }
        public DbSet<SANPHAM> SANPHAM { get; set; }
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {

        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
        }
    }
}
