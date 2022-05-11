package com.example.lms_project.sertificate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/certificate")
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping("/create")
    public ResponseEntity<?> createCertificate(@Valid @RequestBody CertificateDto certificateDto){
        return ResponseEntity.ok().body(certificateService.create(certificateDto));
    }

    @GetMapping(value = "/{token:.+}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable("token") String token){

        if (token!=null && token.length() > 0){
            try {
                return certificateService.getOne(token);
            } catch (Exception e) {
                e.printStackTrace();
                return new byte[0];
            }
        }
        return null;
    }

    // TODO: get All with(paging and sorting)

    @GetMapping("/pagination")
    public ResponseEntity<?> pagination(@Valid @RequestBody CertificateDto certificateDto)
    {
        List<CertificateDto> list = certificateService.getAll(certificateDto);

        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete/{token}")
    public ResponseEntity<?> delete(@PathVariable("token") String token){
        certificateService.delete(token);
        return ResponseEntity.ok("Ok, certificate deleted!");
    }
}
