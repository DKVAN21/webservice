using lib.Data;
using lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Repositories
{
    public interface ISANPHAMRepository : IRepository<SANPHAM>
    {
        List<SANPHAM> GetSANPHAMList();
    }
    public class SANPHAMRepository : RepositoryBase<SANPHAM>, ISANPHAMRepository
    {
        public SANPHAMRepository(ApplicationDbContext dbContext) : base(dbContext)
        {

        }
        public List<SANPHAM> GetSANPHAMList()
        {
            var query = _dbcontext.SANPHAM.AsQueryable();
            return query.ToList();
        }
    }
}
