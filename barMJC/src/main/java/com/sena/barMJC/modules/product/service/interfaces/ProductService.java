package com.sena.barMJC.modules.product.service.interfaces;

import com.sena.barMJC.modules.product.dto.request.ProductCreateDTO;
import com.sena.barMJC.modules.product.dto.request.ProductUpdateDTO;
import com.sena.barMJC.modules.product.dto.response.ProductResponseDTO;
import com.sena.barMJC.shared.service.CrudService;

public interface ProductService extends CrudService<ProductResponseDTO, ProductCreateDTO, ProductUpdateDTO, Long> {

}
