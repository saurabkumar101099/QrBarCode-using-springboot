package com.QR.springbootQRAPP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QR_CodeGenerator {
	public static void generateQRCodeImage(String text, int width, int height, String filepath)
			throws WriterException, IOException {
		QRCodeWriter codeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = codeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		Path path = FileSystems.getDefault().getPath(filepath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	}

	public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		QRCodeWriter codeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = codeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		ByteArrayOutputStream pn = new ByteArrayOutputStream();
		byte[] pngData = pn.toByteArray();
		return pngData;
	}
}
