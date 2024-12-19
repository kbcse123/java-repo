@param java.util.List<com.order.food.model.Item> items
@param String env
@param int cartCount
@param com.order.food.model.CartTotal cartTotal

@template.layout.main(env = env, cartCount = cartCount, content = @`
    @template.checkout-content(items = items, cartTotal = cartTotal)
`)