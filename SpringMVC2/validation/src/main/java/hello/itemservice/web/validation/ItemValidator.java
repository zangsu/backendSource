package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors bindingResult) {
        Item item = (Item) target;

        if(!StringUtils.hasText(item.getItemName())) {
            bindingResult.rejectValue("itemName", "required");
        }
        if(bindingResult.getFieldError("price") == null && (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000))
            bindingResult.rejectValue("price", "range", new Object[]{1_000, 1_000_000}, null);
        if(item.getQuantity() == null || item.getQuantity() > 9999)
            bindingResult.rejectValue("quantity", "max", new Object[]{9999}, null);

        //특정 필드가 아닌, 복합 룰 검증
        if(item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if(resultPrice < 10_000)
                bindingResult.reject("totalPriceMin", new Object[]{10_000, resultPrice}, null);
        }

    }
}
