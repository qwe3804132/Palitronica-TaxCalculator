package net.challenge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import net.challenge.mapper.CustomerMapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import net.challenge.model.CustomerDO;
import net.challenge.service.CustomerService;
import net.challenge.vo.CustomerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * service impl
 * </p>
 *
 * @author Peiran Liu
 * @since 2021-12-08
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerMapper customerMapper;


  @Override
  public List<CustomerVO> list() {

    List<CustomerDO> customerDOList = customerMapper.selectList(
        new QueryWrapper<CustomerDO>().orderByAsc("id"));
    List<CustomerVO> customerVOList = customerDOList.stream().map(obj -> {
      CustomerVO customerVO = new CustomerVO();
      BeanUtils.copyProperties(obj, customerVO);
      return customerVO;
    }).collect(Collectors.toList());
    return customerVOList;
  }

  @Override
  public CustomerVO detail(Long id) {
    CustomerDO customerDO = customerMapper.selectOne(new QueryWrapper<CustomerDO>().eq("id", id));
    if (customerDO == null) {
      return null;
    }

    CustomerVO customerVO = new CustomerVO();
    BeanUtils.copyProperties(customerDO, customerVO);
    return customerVO;
  }
}
