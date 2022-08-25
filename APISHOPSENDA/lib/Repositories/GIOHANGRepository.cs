using lib.Data;
using lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Repositories
{
    public interface IGIOHANGRepository : IRepository<GIOHANG>
    {
        List<GIOHANG> GetGIOHANGList();
    }
    public class GIOHANGRepository : RepositoryBase<GIOHANG>, IGIOHANGRepository
    {
        public GIOHANGRepository(ApplicationDbContext dbContext) : base(dbContext)
        {

        }
        public List<GIOHANG> GetGIOHANGList()
        {
            var query = _dbcontext.GIOHANG.AsQueryable();
            return query.ToList();
        }
        
        
    }
}

