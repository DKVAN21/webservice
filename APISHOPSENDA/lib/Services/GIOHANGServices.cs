using lib.Entity;
using lib.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Services
{

    public class GIOHANGServices
    {
        private IGIOHANGRepository GIOHANGRepository { get; set; }
        private ApplicationDbContext dbContext;

        public GIOHANGServices(ApplicationDbContext dbContext, IGIOHANGRepository GIOHANGRepository)
        {
            this.dbContext = dbContext;
            this.GIOHANGRepository = GIOHANGRepository;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<GIOHANG> GetGIOHANGList()
        {
            return GIOHANGRepository.GetGIOHANGList();
        }
        public void InsertGIOHANG(GIOHANG st)
        {
            GIOHANGRepository.Add(st);
            Save();
        }
        public void ChangeGIOHANG(GIOHANG st)
        {
            GIOHANG gh = dbContext.GIOHANG.Where(p => p.sdt == st.sdt&& p.masp==st.masp).FirstOrDefault();
            gh.soluong = st.soluong;
            gh.tongtien = st.tongtien;
            GIOHANGRepository.Update(st);
            Save();
        }
        public void DeleteGIOHANG(GIOHANG st)
        {
            GIOHANGRepository.Delete(st);
            Save();
        }

    }
}