using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Entity
{
    public class NHANVIEN
    {
        [Key]
        public string manv { get; set; }
        public string tennv { get; set; }
        public string pass { get; set; }
        public string chucvu { get; set; }

    }
}
