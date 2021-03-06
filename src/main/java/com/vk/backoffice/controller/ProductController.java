package com.vk.backoffice.controller;

import com.vk.backoffice.qr.model.Product;
import com.vk.backoffice.qr.service.ProductServiceImpl;
import com.vk.backoffice.qr.util.VankonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/upload/productMaster")
    public String uploadProductMaster(@RequestParam("file") MultipartFile excelDataFile){
        Logger logger = LoggerFactory.getLogger(ProductController.class);
        try {
            XSSFWorkbook workBook = new XSSFWorkbook(excelDataFile.getInputStream());
            XSSFSheet workSheet = workBook.getSheetAt(0);
            List<Product> productList = new ArrayList<>();
            for (int row = 1; row < workSheet.getPhysicalNumberOfRows(); row++) {
                Product product = new Product();
                XSSFRow xslRow = workSheet.getRow(row);
                product.setItemCode(xslRow.getCell(1).getStringCellValue());
                product.setRange(xslRow.getCell(2).getStringCellValue());
                product.setProductName(xslRow.getCell(3).getStringCellValue());
                productList.add(product);
                logger.info(product.toString());
            }
            return productService.processProductMaster(productList);
        }catch (Exception e){
            return VankonConstant.FAILURE;
        }
    }
	
	@GetMapping("/getProductList")
	public List<Product> getProductList(){
		return productService.getProductList();
	}
}
