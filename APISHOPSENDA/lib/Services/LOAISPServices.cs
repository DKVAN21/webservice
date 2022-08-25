using lib.Entity;
using lib.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Services
{
    
    public class LOAISPServices
    {
        private ILOAISPRepository LOAISPRepository { get; set; }
        private ApplicationDbContext dbContext;
        public LOAISPServices(ApplicationDbContext dbContext, ILOAISPRepository LOAISPRepository)
        {
            this.dbContext = dbContext;
            this.LOAISPRepository = LOAISPRepository;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<LOAISP> GetLOAISPList()
        {
            return LOAISPRepository.GetLOAISPList();
        }
        public void InsertLOAISP(LOAISP st)
        {
            LOAISPRepository.Add(st);
            Save();
        }
        public void ChangeLOAISP(LOAISP st)
        {
            LOAISP lsp = dbContext.LOAISP.Where(p => p.maloai ==st.maloai).FirstOrDefault();
            lsp.tenloai = st.tenloai;
            LOAISPRepository.Update(lsp);
            Save();
        }
        public void DeleteLOAISP(LOAISP st)
        {
            LOAISPRepository.Delete(st);
            Save();
        }
    }
}
