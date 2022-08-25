using lib.Entity;
using lib.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Services
{
    public class KHACHHANGServices
    {
        private IKHACHHANGRepository KHACHHANGRepository { get; set; }
        private ApplicationDbContext dbContext;
        public KHACHHANGServices(ApplicationDbContext dbContext, IKHACHHANGRepository KHACHHANGRepository)
        {
            this.dbContext = dbContext;
            this.KHACHHANGRepository = KHACHHANGRepository;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<KHACHHANG> GetKHACHHANGList()
        {
            return KHACHHANGRepository.GetKHACHHANGList();
        }
        public int  KTDN(KHACHHANG st)
        {
            KHACHHANG kh = dbContext.KHACHHANG.Where(p => p.sdt == st.sdt&& p.pass==st.pass).FirstOrDefault();
            if (kh != null)
            {
                return 1;
            }
            else
            {
                return 0;
            }
            
        }
        public void InsertKHACHHANG(KHACHHANG st)
        {
            KHACHHANGRepository.Add(st);
            Save();
        }
        public void ChangeKHACHHANG(KHACHHANG st)
        {
            KHACHHANG kh = dbContext.KHACHHANG.Where(p => p.sdt == st.sdt).FirstOrDefault();
            kh.tenkh = st.tenkh;
            kh.pass = st.pass;
            kh.diachi = st.diachi;
            kh.email = st.email;
            KHACHHANGRepository.Update(kh);
            Save();
        }
        public void DeleteKHACHHANG(KHACHHANG st)
        {
            KHACHHANGRepository.Delete(st);
            Save();
        }
    }
}
