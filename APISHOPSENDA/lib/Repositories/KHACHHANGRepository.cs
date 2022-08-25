using lib.Data;
using lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Repositories
{
    public interface IKHACHHANGRepository : IRepository<KHACHHANG>
    {
        List<KHACHHANG> GetKHACHHANGList();
    }
    public class KHACHHANGRepository : RepositoryBase<KHACHHANG>, IKHACHHANGRepository
    {
        public KHACHHANGRepository(ApplicationDbContext dbContext) : base(dbContext)
        {

        }
        public List<KHACHHANG> GetKHACHHANGList()
        {
            var query = _dbcontext.KHACHHANG.AsQueryable();
            return query.ToList();
        }
    }
}
