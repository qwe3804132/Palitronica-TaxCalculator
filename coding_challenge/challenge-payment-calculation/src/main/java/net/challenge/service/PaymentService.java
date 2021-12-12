package net.challenge.service;

import com.taxjar.model.taxes.TaxResponse;
import java.util.List;
import net.challenge.request.LineItem;
import net.challenge.vo.TaxVO;

public interface PaymentService {
public TaxVO paymentCalculation(long userId, List<LineItem> items);
}
