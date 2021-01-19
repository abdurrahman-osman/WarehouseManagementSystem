package com.fimba.WarehouseManagmentSystem.Service.WarehouseService;

import com.fimba.WarehouseManagmentSystem.Converter.WarehouseConverterImpl.DTOToWarehouseConverter;
import com.fimba.WarehouseManagmentSystem.Converter.WarehouseConverterImpl.WarehouseToDTOConverter;
import com.fimba.WarehouseManagmentSystem.Dao.WarehouseAPICRUDRepository;
import com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.WarehouseCRUDRepository;
import com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.WarehouseOperationRepository;
import com.fimba.WarehouseManagmentSystem.Model.Dto.WarehouseDTO;
import com.fimba.WarehouseManagmentSystem.Model.Entities.WarehouseEntity;
import com.fimba.WarehouseManagmentSystem.Response.ResponseError;
import com.fimba.WarehouseManagmentSystem.Response.ResponseHolder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WarehouseServiceImpl implements WarehouseService{
    private final WarehouseToDTOConverter WarehousetoDTOConverter;
    private final DTOToWarehouseConverter toWarehouseConverter;
    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final WarehouseOperationRepository operationRepository;

    @Override
    public ResponseHolder<Collection<WarehouseDTO>> list() {
        Collection<WarehouseEntity> entities = warehouseCRUDRepository.list();
        if (CollectionUtils.isEmpty(entities))
            return new ResponseHolder<>(HttpStatus.NOT_FOUND,new ResponseError("NOT_FOUND","No data"));
        List<WarehouseDTO> warehouseDTOList = entities.stream().map(WarehousetoDTOConverter::convert)
                .collect(Collectors.toList());
        return new ResponseHolder<>(warehouseDTOList,HttpStatus.OK);
    }

    @Override
    public ResponseHolder<WarehouseDTO> create(WarehouseDTO warehouseDTO) {
        WarehouseEntity warehouseEntity = toWarehouseConverter.convert(warehouseDTO);
        if(operationRepository.hasExistSameWarehouseCode(warehouseDTO.getCode()))
            return new ResponseHolder<>(HttpStatus.NO_CONTENT,new ResponseError("DUPLICATE_DATA","This warehouse is already created"));
        warehouseEntity.setCreatedAt(new Date());
        warehouseDTO= WarehousetoDTOConverter.convert(warehouseCRUDRepository.create(warehouseEntity));
        return new ResponseHolder<>(warehouseDTO,HttpStatus.OK);
    }

    @Override
    public ResponseHolder<WarehouseDTO> update(WarehouseDTO entity) {
        WarehouseEntity warehouseEntity = toWarehouseConverter.convert(entity);
        warehouseCRUDRepository.update(warehouseEntity);
        return null;
    }

    @Override
    public ResponseHolder<?> delete(WarehouseDTO id) {
        return null;
    }
}
