//package com.capgemini.GoCab.service;
//
//import java.io.IOException;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.capgemini.GoCab.entity.ImageEntity;
//import com.capgemini.GoCab.exception.ImageCouldNotBeSavedException;
//import com.capgemini.GoCab.exception.ImageCouldNotFoundException;
//
//public interface ImageService {
//
//	boolean saveImage(MultipartFile imageFile) throws ImageCouldNotBeSavedException, IOException;
//	
//	ImageEntity getImage(String imageUsername) throws ImageCouldNotFoundException;
//}
