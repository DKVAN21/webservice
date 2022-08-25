using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Entity
{
   public  class GIOHANG
    {
        [Key]
        public string masp { get; set; }
        public string sdt { get; set; }
        public int tongtien { get; set; }
        public int soluong { get; set; }
    }
}
