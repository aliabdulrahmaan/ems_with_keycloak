//package com.ems.EmployeeManagementService.mapper;
//
//
//import com.ems.EmployeeManagementService.entites.Role;
//import com.ems.EmployeeManagementService.entites.Token;
//import com.ems.EmployeeManagementService.service.dtos.TokenDTO;
//import org.modelmapper.Converter;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeMap;
//import org.modelmapper.spi.MappingContext;
//import org.springframework.stereotype.Component;
//
//import java.util.stream.Collectors;
//
//@Component
//public class TokenMapper {
//    private ModelMapper modelMapper = new ModelMapper();
//
//    public TokenDTO toDTO(Token token){
////        TypeMap<Token, TokenDTO> tm = modelMapper.getTypeMap(Token.class, TokenDTO.class);
//
//        Converter<Token, TokenDTO> converter = new Converter<Token, TokenDTO>()
//        {
//            public TokenDTO convert(MappingContext<Token, TokenDTO> context)
//            {
//                Token s = context.getSource();
//                TokenDTO d = new TokenDTO();
//                d.setAccessToken(s.getAccessToken());
//                d.setRefreshToken(s.getRefreshToken() );
//                d.setRoles(s.getUser().getRoles().stream().
//                        map(r->r.getName().toString()).collect(Collectors.toSet()));
//                return d;
//            }
//        };
//        modelMapper.addConverter(converter);
//        return modelMapper.map(token,TokenDTO.class);
//    }
//}
