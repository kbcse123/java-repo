@import com.order.food.model.Item
@param java.util.List<Item> items
@param String env
@param int cartCount

@template.layout.main(env = env, cartCount = cartCount, content = @`

    @template.home-content(items = items)

`)