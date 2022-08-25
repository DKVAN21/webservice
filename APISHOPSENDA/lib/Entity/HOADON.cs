using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Entity
{
    public  class HOADON
    {
        [Key]
        public String  mahd { get; set; }
        public int thanhtien { get; set; }
        public string manv { get; set; }
        public string masp { get; set; }
        public string sdt { get; set; }
    }
}
