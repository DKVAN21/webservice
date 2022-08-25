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
    public class LOAISPController : ControllerBase
    {
        private LOAISPServices LOAISPService;

        public LOAISPController(LOAISPServices LOAISPService)
        {
            this.LOAISPService = LOAISPService;
        }
        [HttpGet("get-LOAISP")]
        public async Task<ActionResult> GetLOAISP()
        {
            return Ok(new { status = true, message1 = "", data = LOAISPService.GetLOAISPList() });
        }
        [HttpPost("insert-LOAISP")]
        public async Task<ActionResult> InsertLOAISP(LOAISPModel Loaisp)
        {
            LOAISP lsp = new LOAISP();
            lsp.maloai = Loaisp.maloai;
            LOAISPService.InsertLOAISP(lsp);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPut("Change-LOAISP")]
        public async Task<ActionResult> ChangeLOAISP(LOAISPModel Loaisp)
        {
            LOAISP lsp = new LOAISP();
            lsp.maloai = Loaisp.maloai;
            LOAISPService.ChangeLOAISP(lsp);
            return Ok(new { status = true, message = "success" });
        }
    }
}
