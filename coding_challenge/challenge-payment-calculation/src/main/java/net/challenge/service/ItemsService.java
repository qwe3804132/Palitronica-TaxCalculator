package net.challenge.service;

import java.util.List;
import net.challenge.model.ItemsDO;
import com.baomidou.mybatisplus.extension.service.IService;
import net.challenge.vo.CustomerVO;
import net.challenge.vo.ItemsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Peiran Liu
 * @since 2021-12-08
 */
public interface ItemsService  {
  public List<ItemsVO> listAllItems();

}
