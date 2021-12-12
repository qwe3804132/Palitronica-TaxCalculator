package net.challenge.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Peiran Liu
 * @since 2021-12-08
 */
@Data

public class ItemsVO  {


    private Long id;

    private String title;

    private String details;

    private BigDecimal amount;


}
