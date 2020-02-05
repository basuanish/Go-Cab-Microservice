//package com.capgemini.GoCab.service;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.Optional;
//import java.util.zip.DataFormatException;
//import java.util.zip.Deflater;
//import java.util.zip.Inflater;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.capgemini.GoCab.dao.IImageDao;
//import com.capgemini.GoCab.dto.ImageModel;
//import com.capgemini.GoCab.entity.ImageEntity;
//import com.capgemini.GoCab.exception.ImageCouldNotBeSavedException;
//import com.capgemini.GoCab.exception.ImageCouldNotFoundException;
//
//@Service
//public class ImageServiceImpl implements ImageService {
//
//	@Autowired
//	private IImageDao iDao;
//	
//	public ImageServiceImpl() {
//	}
//
//	@Override
//	public boolean saveImage(MultipartFile imageFile) throws ImageCouldNotBeSavedException, IOException {
//		ImageEntity ie = new ImageEntity(imageFile.getOriginalFilename(),
//										 imageFile.getContentType(),
//										 compressBytes(imageFile.getBytes()));
//		
//		iDao.save(ie);
//		
//		return true;
//	}
//	
//	// Compressing image method
//	public static byte[] compressBytes(byte[] data) {
//		Deflater deflater = new Deflater();
//		deflater.setInput(data);
//		deflater.finish();
//
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		while (!deflater.finished()) {
//			int count = deflater.deflate(buffer);
//			outputStream.write(buffer, 0, count);
//		}
//		try {
//			outputStream.close();
//		} catch (IOException e) {
//		}
//		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//
//		return outputStream.toByteArray();
//	}
//
//	@Override
//	public ImageEntity getImage(String imageUsername) throws ImageCouldNotFoundException {
//		Optional<ImageEntity> ie = iDao.findById(imageUsername);
//		
//		ImageEntity iE =  new ImageEntity(ie.get().getImageUsername(),
//										  ie.get().getType(),
//										  decompressBytes(ie.get().getImage()));
//		
//		return iE;
//	}
//
//	public static byte[] decompressBytes(byte[] data) {
//		Inflater inflater = new Inflater();
//		inflater.setInput(data);
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		try {
//			while (!inflater.finished()) {
//				int count = inflater.inflate(buffer);
//				outputStream.write(buffer, 0, count);
//			}
//			outputStream.close();
//		} catch (IOException ioe) {
//		} catch (DataFormatException e) {
//		}
//		return outputStream.toByteArray();
//	}
//}
