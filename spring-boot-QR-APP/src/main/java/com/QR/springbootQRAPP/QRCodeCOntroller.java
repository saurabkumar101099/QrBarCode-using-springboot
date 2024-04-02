package com.QR.springbootQRAPP;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

@RestController
public class QRCodeCOntroller {
	private static final String QR_CPDE_IMAGE_PATH="./src/main/resources/QRCode.png";
	@GetMapping ("/genrateANdDownloadQRCode/{codeText}/{width}/{height}")
public void download(@PathVariable String codeText, @PathVariable int width, @PathVariable int height) throws WriterException, IOException {
		QR_CodeGenerator.generateQRCodeImage(codeText, width, height,QR_CPDE_IMAGE_PATH);
	}
	@GetMapping("/generateQRCode/{codeText}/{width}/{height}")
	public ResponseEntity<byte[]> generateQRCode(@PathVariable String codeText,@PathVariable int width,int height) throws WriterException, IOException{
		return ResponseEntity.status(HttpStatus.OK).body(QR_CodeGenerator.getQRCodeImage(codeText, width, height));
				
	}
}
