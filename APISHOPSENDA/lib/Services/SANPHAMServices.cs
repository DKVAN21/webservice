using lib.Entity;
using lib.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Services
{
    public class SANPHAMServices
    {
        private ISANPHAMRepository SANPHAMRepository { get; set; }
        private ApplicationDbContext dbContext;

        public SANPHAMServices(ApplicationDbContext dbContext, ISANPHAMRepository SANPHAMRepository)
        {
            this.dbContext = dbContext;
            this.SANPHAMRepository = SANPHAMRepository;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<SANPHAM> GetSANPHAMList()
        {
            return SANPHAMRepository.GetSANPHAMList();
        }
        public void InsertSANPHAM(SANPHAM st)
        {
            SANPHAMRepository.Add(st);
            Save();
        }
        public void ChangeSANPHAM(SANPHAM st)
        {
            SANPHAM sp = dbContext.SANPHAM.Where(p => p.masp == st.masp).FirstOrDefault();
            sp.tensp = st.tensp;
            sp.gia = st.gia;
            sp.hinh = st.hinh;
            sp.kichco = st.kichco;
            sp.mota = st.mota;
            sp.soluong = st.soluong;
            sp.maloai = st.maloai;
            SANPHAMRepository.Update(sp);
            Save();
        }
        public void DeleteSANPHAM(SANPHAM st)
        {
            SANPHAMRepository.Delete(st);
            Save();
        }
    }
}
