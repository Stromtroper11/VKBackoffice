package com.vk.backoffice.controller;

import com.vk.backoffice.qr.model.CreateQrRequest;
import com.vk.backoffice.qr.model.QrMaster;
import com.vk.backoffice.qr.service.QrCodeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class QrController {

    @Autowired
    private QrCodeServiceImpl qrCodeService;

    @PostMapping(path = "/generateQRExcel")
    public ResponseEntity<String> printQrForExcel(@RequestBody CreateQrRequest qrRequest) {
        System.out.println(qrRequest.toString());
        if(qrRequest != null) {
            Resource resource = qrCodeService.generateCodeByProductToExcel(qrRequest);
            if(resource != null) {
                System.out.println("FileName " + resource.getFilename());
                return new ResponseEntity<>(resource.getFilename(), HttpStatus.OK);
            }
        }
        return null;
    }

    @RequestMapping(path = "/downloadExcel/{fileName}", method = RequestMethod.GET)
    public ResponseEntity downloadFile(@PathVariable(name = "fileName" , required = true) String fileName){
        Resource resource = qrCodeService.createResource(fileName+".xlsx");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping(path = "/getQrList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QrMaster> getQrMasterList(){
        return qrCodeService.getQrMasterInformation();
    }
}
