package net.challenge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.challenge.model.ItemsDO;
import net.challenge.mapper.ItemsMapper;
import net.challenge.service.ItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.challenge.vo.ItemsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  service impl
 * </p>
 *
 * @author Peiran Liu
 * @since 2021-12-08
 */
@Service
@Slf4j
public class ItemsServiceImpl implements ItemsService {

  @Autowired
  private ItemsMapper itemsMapper;
  @Override
  public List<ItemsVO> listAllItems() {

    List<ItemsDO> itemsDOList = itemsMapper.selectList(
        new QueryWrapper<ItemsDO>().orderByAsc("id"));
    List<ItemsVO> itemsVOList = itemsDOList.stream().map(obj -> {
      ItemsVO itemsVO = new ItemsVO();
      BeanUtils.copyProperties(obj, itemsVO);
      return itemsVO;
    }).collect(Collectors.toList());
    return itemsVOList;
  }

}
