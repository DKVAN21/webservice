using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using lib;
using lib.Services;
using APISHOPSENDA.Models;
using lib.Entity;

namespace APISHOPSENDA.Controllers.api
{
    [Route("api/[controller]")]
    [ApiController]
    public class GIOHANGController : ControllerBase
    {
        private GIOHANGServices GIOHANGService;

        public GIOHANGController(GIOHANGServices GIOHANGService)
        {
            this.GIOHANGService = GIOHANGService;
        }
        [HttpGet("get-GIOHANG")]
        public async Task<ActionResult> GetGIOHANG()
        {
            return Ok(new { status = true, message1 = "", data = GIOHANGService.GetGIOHANGList() });
        }
        [HttpPost("insert-GIOHANG")]
        public async Task<ActionResult> InsertGIOHANG(GIOHANGModel Giohang)
        {
            GIOHANG gh = new GIOHANG();
            gh.masp = Giohang.masp;
            gh.sdt = Giohang.sdt;
            gh.soluong = Giohang.soluong;
            gh.tongtien = Giohang.tongtien;
            GIOHANGService.InsertGIOHANG(gh);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPut("Change-GIOHANG")]
        public async Task<ActionResult> ChangeGIOHANG(GIOHANGModel Giohang)
        {
            GIOHANG gh = new GIOHANG();
            gh.masp = Giohang.masp;
            gh.sdt = Giohang.sdt;
            gh.soluong = Giohang.soluong;
            gh.tongtien = Giohang.tongtien;
            GIOHANGService.ChangeGIOHANG(gh);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPost("Delete-GIOHANG")]
        public async Task<ActionResult> DeleteGIOHANG(GIOHANGModel Giohang)
        {
            GIOHANG gh = new GIOHANG();
            gh.masp = Giohang.masp;
            GIOHANGService.DeleteGIOHANG(gh);
            return Ok(new { status = true, message = "success" });
        }
    }
}
