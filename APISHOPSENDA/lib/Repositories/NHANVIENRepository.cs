using lib.Data;
using lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Repositories
{
    public interface INHANVIENRepository : IRepository<NHANVIEN>
    {
        List<NHANVIEN> GetNHANVIENList();
    }
    public class NHANVIENRepository : RepositoryBase<NHANVIEN>, INHANVIENRepository
    {
        public NHANVIENRepository(ApplicationDbContext dbContext) : base(dbContext)
        {

        }
        public List<NHANVIEN> GetNHANVIENList()
        {
            var query = _dbcontext.NHANVIEN.AsQueryable();
            return query.ToList();
        }
    }
}
