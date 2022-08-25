using lib.Data;
using lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Repositories
{
    public interface IHOADONRepository : IRepository<HOADON>
    {
        List<HOADON> GetHOADONList();
    }
    public class HOADONRepository : RepositoryBase<HOADON>, IHOADONRepository
    {
        public HOADONRepository(ApplicationDbContext dbContext) : base(dbContext)
        {

        }
        public List<HOADON> GetHOADONList()
        {
            var query = _dbcontext.HOADON.AsQueryable();
            return query.ToList();
        }
    }
}
