using APISHOPSENDA.Models;
using lib.Entity;
using lib.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace APISHOPSENDA.Controllers.api
{
    [Route("api/[controller]")]
    [ApiController]
    public class NHANVIENController : ControllerBase
    {
        
        private NHANVIENServices NHANVIENService;

        public NHANVIENController(NHANVIENServices NHANVIENService)
        {
            this.NHANVIENService = NHANVIENService;
        }
        [HttpGet("get-NHANVIEN")]
        public async Task<ActionResult> GetNHANVIEN()
        {
            return Ok(new { status = true, message1 = "", data = NHANVIENService.GetNHANVIENList() });
        }
        [HttpPost("insert-NHANVIEN")]
        public async Task<ActionResult> InsertNHANVIEN(NHANVIENModel Nhanvien)
        {
            NHANVIEN nv = new NHANVIEN();
            nv.manv = Nhanvien.manv;
            nv.tennv = Nhanvien.tennv;
            nv.chucvu = Nhanvien.chucvu;
            nv.pass = Nhanvien.pass;
            NHANVIENService.InsertNHANVIEN(nv);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPut("Change-NHANVIEN")]
        public async Task<ActionResult> ChangeNHANVIEN(NHANVIENModel Nhanvien)
        {
            NHANVIEN nv = new NHANVIEN();
            nv.manv = Nhanvien.manv;
            nv.tennv = Nhanvien.tennv;
            nv.chucvu = Nhanvien.chucvu;
            nv.pass = Nhanvien.pass;
            NHANVIENService.ChangeNHANVIEN(nv);
            return Ok(new { status = true, message = "success" });
        }
        [HttpDelete("Delete-NHANVIEN")]
        public async Task<ActionResult> DeleteNHANVIEN(NHANVIENModel Nhanvien)
        {
            NHANVIEN nv = new NHANVIEN();
            nv.manv = Nhanvien.manv;
            NHANVIENService.DeleteNHANVIEN(nv);
            return Ok(new { status = true, message = "success" });
        }
    }
}
