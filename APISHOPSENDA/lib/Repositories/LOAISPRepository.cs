using lib.Data;
using lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Repositories
{
    public interface ILOAISPRepository : IRepository<LOAISP>
    {
        List<LOAISP> GetLOAISPList();
    }
    public class LOAISPRepository : RepositoryBase<LOAISP>, ILOAISPRepository
    {
        public LOAISPRepository(ApplicationDbContext dbContext) : base(dbContext)
        {

        }
        public List<LOAISP> GetLOAISPList()
        {
            var query = _dbcontext.LOAISP.AsQueryable();
            return query.ToList();
        }
    }
}
