using lib.Entity;
using lib.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Services
{
    public class NHANVIENServices
    {
        private INHANVIENRepository NHANVIENRepository { get; set; }
        private ApplicationDbContext dbContext;

        public NHANVIENServices(ApplicationDbContext dbContext, INHANVIENRepository NHANVIENRepository)
        {
            this.dbContext = dbContext;
            this.NHANVIENRepository = NHANVIENRepository;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<NHANVIEN> GetNHANVIENList()
        {
            return NHANVIENRepository.GetNHANVIENList();
        }
        public void InsertNHANVIEN(NHANVIEN st)
        {
            NHANVIENRepository.Add(st);
            Save();
        }
        public void ChangeNHANVIEN(NHANVIEN st)
        {
            NHANVIEN nv = dbContext.NHANVIEN.Where(p => p.manv == st.manv).FirstOrDefault();
            nv.tennv = st.tennv;
            nv.chucvu = st.chucvu;
            nv.pass = st.pass;
            NHANVIENRepository.Update(nv);
            Save();
        }
        public void DeleteNHANVIEN(NHANVIEN st)
        {
            NHANVIENRepository.Delete(st);
            Save();
        }
    }
}
