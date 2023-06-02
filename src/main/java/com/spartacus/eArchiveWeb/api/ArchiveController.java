package com.spartacus.eArchiveWeb.api;

import com.spartacus.eArchiveWeb.business.ArchiveService;
import com.spartacus.eArchiveWeb.business.FinderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/archive")
public class ArchiveController {
    private final ArchiveService archiveService;
    private final FinderService finderService;
    @Value("${recv.path}")
    private String RECV_PATH;
    @Value("${send.path}")
    private String SEND_PATH;
    public ArchiveController(ArchiveService archiveService, FinderService finderService){
        this.archiveService = archiveService;
        this.finderService = finderService;
    }

    @GetMapping("get/status/{envelopeId}")
    public String getEArchiveStatus(@PathVariable String envelopeId){
        return archiveService.getEArchiveStatus();
    }

    @GetMapping("/find/invoice/{status}/{envelopeId}/{invoiceId}")
    public String findInvoice(@PathVariable String status, @PathVariable String envelopeId, @PathVariable String invoiceId){
        if(!(status.isEmpty() || status == null)){
            String envelopeFile = null;
            if(status.equalsIgnoreCase("gelen")){
                envelopeFile = RECV_PATH + envelopeId + ".xml";
                return finderService.findInvoice(envelopeId, envelopeFile, RECV_PATH);
            }else if(status.equalsIgnoreCase("giden")){
                envelopeFile = SEND_PATH + envelopeId + ".xml";
                return finderService.findInvoice(envelopeId, envelopeFile, SEND_PATH);
            }else{
                return "'HATACIK: Beklediğim değerler bunlar değil ki ! !";
            }
        }else{
            return "HATACIK: Gelen mi giden mi bilemedim ben !";
        }

    }
}
