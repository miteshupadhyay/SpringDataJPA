package com.mitesh.springdata.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitesh.springdata.files.entities.Image;
import com.mitesh.springdata.files.repos.ImageRepository;

@SpringBootTest
class FilesApplicationTests {

	@Autowired
	ImageRepository imageRepository;
	
	@Test
	public void testImageSave() throws IOException
	{
		Image image=new Image();
			image.setId(1L);
			image.setName("Policy.jpg");
			
			File file=new File("C:/Users/ADMIN/Desktop/Policy.jpg");
			byte fileContent[]=new byte[(int)file.length()];
			FileInputStream fileInputStream=new FileInputStream(file);
			fileInputStream.read(fileContent);
			
			image.setData(fileContent);
			imageRepository.save(image);
			fileInputStream.close();			
	}
	
	@Test
	public void testReadSave() throws IOException
	{
		Optional<Image> findById = imageRepository.findById(1L);
		File file=new File("F:/Java Workspace/SpringDataJPA/Downloaded_Images/"+findById.get().getName());
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		fileOutputStream.write(findById.get().getData());
	}
}
