using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Entity
{
    public class KHACHHANG
    {
        [Key]
        public string sdt { get; set; }
        public string tenkh { get; set; }
        public string email { get; set; }
        public string pass { get; set; }
        public string diachi { get; set; }
    }
}
