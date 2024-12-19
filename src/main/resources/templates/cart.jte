@import com.order.food.model.Item
@param java.util.List<Item> items
@param String env
@param int cartCount
@param com.order.food.model.CartTotal cartTotal

@template.layout.main(env = env, cartCount = cartCount, content = @`
    @template.cart-content(items = items, cartTotal = cartTotal)
`)