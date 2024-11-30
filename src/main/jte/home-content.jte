@import com.order.food.model.Item
@param java.util.List<Item> items

<div id="main-content">
    <div class="container-fluid fruite py-5">
        <div class="container py-5">
            <h4 class="mb-4">Breakfast</h4>

            <div class="text-center">
                <div class="row g-4">
                    <div class="col-lg-12">
                        <div class="row g-4">
                            @for(Item item: items)
                               @template.foodItem(foodItem = item)
                            @endfor
                        </div>
                    </div>
                </div>
            </div>
            <br/>
            <h4 class="mb-4">Evening Snacks</h4>

            <br/>
            <h4 class="mb-4">Dinner</h4>
        </div>
    </div>
</div>