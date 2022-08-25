using lib.Entity;
using lib.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Services
{
   public class HOADONServices
    {
        private IHOADONRepository HOADONRepository { get; set; }
        private ApplicationDbContext dbContext;

        public HOADONServices(ApplicationDbContext dbContext, IHOADONRepository HOADONRepository)
        {
            this.dbContext = dbContext;
            this.HOADONRepository = HOADONRepository;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<HOADON> GetHOADONList()
        {
            return HOADONRepository.GetHOADONList();
        }
        public void InsertHOADON(HOADON st)
        {
            HOADONRepository.Add(st);
            Save();
        }
        public void ChangeHOADON(HOADON st)
        {
            HOADON hd = dbContext.HOADON.Where(p => p.mahd==st.mahd).FirstOrDefault();
            hd.sdt = st.sdt;
            hd.manv = st.manv;
            hd.masp = st.masp;
            hd.sdt = st.sdt;
            HOADONRepository.Update(st);
            Save();
        }
        public void DeleteHOADON(HOADON st)
        {
            HOADONRepository.Delete(st);
            Save();
        }
    }
}
