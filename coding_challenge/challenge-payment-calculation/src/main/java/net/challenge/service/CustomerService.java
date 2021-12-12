package net.challenge.service;

import java.util.List;
import net.challenge.model.CustomerDO;
import com.baomidou.mybatisplus.extension.service.IService;
import net.challenge.vo.CustomerVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Peiran Liu
 * @since 2021-12-08
 */
public interface CustomerService  {

  /**
   * fetching all customers
   * @return
   */
  public List<CustomerVO> list();

  /**
   * fetch details by customer id
   * @param id
   * @return
   */
  public CustomerVO detail(Long id);



}
