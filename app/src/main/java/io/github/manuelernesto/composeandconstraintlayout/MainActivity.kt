package io.github.manuelernesto.composeandconstraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.core.tag
import androidx.ui.foundation.Border
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.colorResource
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import io.github.manuelernesto.composeandconstraintlayout.ui.ComposeAndConstraintLayoutTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndConstraintLayoutTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Scaffold(
            topAppBar = {
                TopAppBar(
                        elevation = 0.dp,
                        title = { Text(text = "") },
                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(imageResource(R.drawable.back))
                            }
                        },
                        actions = {
                            IconButton(onClick = { }) {
                                Icon(imageResource(R.drawable.search))
                            }
                            IconButton(onClick = { }) {
                                Icon(imageResource(R.drawable.cart)
                                )
                            }

                        }
                )
            },
            bodyContent = {
                HomeContent()
            }
    )
}

@Composable
fun HomeContent(product: Product = mProduct) {

    ConstraintLayout(modifier = Modifier.fillMaxSize(), constraintSet = MainConstraintSet()) {

        Card(
                shape = RoundedCornerShape(topLeft = 24.dp, topRight = 24.dp),
                elevation = 0.dp,
                modifier = Modifier.tag("BgCard").preferredHeight(444.dp).fillMaxWidth()
        ) {
            ConstraintLayout(modifier = Modifier.padding(16.dp), constraintSet = CardConstraintSet()) {
                Text(
                        modifier = Modifier.tag("TxtColor").padding(top = 64.dp),
                        text = "Color",
                        color = Color.Gray
                )
                Button(
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp),
                        modifier =
                        Modifier.tag("Color1").padding(top = 8.dp).width(15.dp).height(15.dp),
                        backgroundColor = colorResource(id = R.color.primary_color),
                        onClick = {}) {}

                Button(
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp),
                        modifier =
                        Modifier.tag("Color2").padding(top = 8.dp, start = 8.dp).width(15.dp).height(15.dp),
                        backgroundColor = colorResource(id = R.color.product_option_color_2),
                        onClick = {}) {}

                Button(
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp),
                        modifier =
                        Modifier.tag("Color3").padding(top = 8.dp, start = 8.dp).width(15.dp).height(15.dp),
                        backgroundColor = colorResource(id = R.color.product_option_color_3),
                        onClick = {}) {}
                Text(
                        modifier = Modifier.tag("TxtSize").padding(top = 64.dp, start = 64.dp),
                        text = "Size",
                        color = Color.Gray
                )
                Text(
                        modifier = Modifier.tag("TxtSizeValue").padding(start = 64.dp, top = 8.dp, bottom = 16.dp),
                        text = product.size,
                        color = Color.DarkGray
                )
                Text(
                        modifier = Modifier.tag("TxtDescription"),
                        text = product.description,
                        color = Color.Gray
                )
                OutlinedButton(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.tag("BtnMinus").padding(top = 32.dp, end = 16.dp),
                        onClick = {}) {
                    Text(text = "-", fontSize = 23.sp)
                }
                Text(
                        modifier = Modifier.tag("TxtQtd").padding(top = 32.dp),
                        text = "01",
                        fontSize = 23.sp,
                        color = Color.DarkGray
                )
                OutlinedButton(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.tag("BtnPlus")
                                .padding(top = 32.dp, start = 16.dp),
                        onClick = {}) {
                    Text(text = "+", fontSize = 23.sp)
                }

                FloatingActionButton(
                        modifier = Modifier.tag("BtnHeart").padding(top = 32.dp),
                        backgroundColor = colorResource(id = R.color.heart_bg_color),
                        elevation = 0.dp,
                        onClick = {}) {
                    Image(asset = imageResource(R.drawable.heart))
                }

                OutlinedButton(
                        border = Border(
                                size = 1.dp,
                                color = colorResource(id = R.color.primary_color)
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.tag("BtnAddtoCart")
                                .padding(top = 32.dp),
                        onClick = {}) {
                    Image(asset = imageResource(R.drawable.add_to_cart))
                }

                Button(
                        elevation = 0.dp,
                        shape = RoundedCornerShape(16.dp),
                        modifier =
                        Modifier.tag("BtnBuy").padding(top = 32.dp).width(275.dp),
                        backgroundColor = colorResource(id = R.color.primary_color),
                        onClick = {}) {
                    Text(text = "BUY NOW", fontSize = 23.sp, color = Color.White)
                }


            }


        }

        Image(
                contentScale = ContentScale.Crop,
                asset = imageResource(id = product.img),
                modifier = Modifier.tag("ProductImage")
                        .preferredWidth(237.dp)
                        .preferredHeight(261.dp)
                        .padding(end = 32.dp, bottom = 62.dp)
        )

        Text(
                modifier = Modifier.tag("ProductCategory")
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                text = "Aristocratic Hand Bag",
                fontSize = 20.sp,
                color = Color.White
        )

        Text(
                modifier = Modifier.tag("ProductTitle")
                        .padding(start = 16.dp),
                text = product.title,
                fontSize = 30.sp,
                color = Color.White
        )


        Text(
                modifier = Modifier.tag("ProductPrice")
                        .padding(start = 16.dp, bottom = 8.dp, top = 8.dp),
                text = product.price,
                fontSize = 30.sp,
                color = Color.White
        )

        Text(
                modifier = Modifier.tag("ProductPriceLabel")
                        .padding(start = 16.dp),
                text = "Price",
                fontSize = 20.sp,
                color = Color.White
        )


    }
}

@Composable
fun CardConstraintSet() = ConstraintSet {
    val txtColor = tag("TxtColor").apply {
        top constrainTo parent.top
        left constrainTo parent.left
    }

    val txtSize = tag("TxtSize").apply {
        top constrainTo txtColor.top
        left constrainTo txtColor.right
    }
    val txtSizeValue = tag("TxtSizeValue").apply {
        top constrainTo txtSize.bottom
        left constrainTo txtSize.left
    }

    val txtDescription = tag("TxtDescription").apply {
        top constrainTo txtSizeValue.bottom
        left constrainTo parent.left
        right constrainTo parent.right
    }

    val btnMinus = tag("BtnMinus").apply {
        top constrainTo txtDescription.bottom
        left constrainTo parent.left
    }

    val txtQtd = tag("TxtQtd").apply {
        top constrainTo btnMinus.top
        bottom constrainTo btnMinus.bottom
        left constrainTo btnMinus.right
    }

    val btnPlus = tag("BtnPlus").apply {
        top constrainTo txtDescription.bottom
        left constrainTo txtQtd.right
    }

    val btnHeart = tag("BtnHeart").apply {
        top constrainTo btnPlus.top
        bottom constrainTo btnPlus.bottom
        right constrainTo parent.right
    }

    val btnAddtoCart = tag("BtnAddtoCart").apply {
        top constrainTo btnMinus.bottom
        left constrainTo parent.left
    }

    val btnBuy = tag("BtnBuy").apply {
        top constrainTo btnMinus.bottom
        left constrainTo btnAddtoCart.right
        right constrainTo parent.right
    }

    val color1 = tag("Color1").apply {
        top constrainTo txtColor.bottom
        left constrainTo parent.left
    }

    val color2 = tag("Color2").apply {
        top constrainTo txtColor.bottom
        left constrainTo color1.right
    }

    val color3 = tag("Color3").apply {
        top constrainTo txtColor.bottom
        left constrainTo color2.right
    }
}

@Composable
fun MainConstraintSet() = ConstraintSet {

    val bgCard = tag("BgCard").apply {
        bottom constrainTo parent.bottom
    }
    val productImage = tag("ProductImage").apply {
        top constrainTo bgCard.top
        bottom constrainTo bgCard.top
        right constrainTo bgCard.right
    }
    val productCategory = tag("ProductCategory").apply {
        top constrainTo parent.top
        left constrainTo parent.left
    }
    val productTitle = tag("ProductTitle").apply {
        top constrainTo productCategory.bottom
        left constrainTo parent.left
    }
    val productPrice = tag("ProductPrice").apply {
        bottom constrainTo bgCard.top
        left constrainTo parent.left
    }
    val productPriceLabel = tag("ProductPriceLabel").apply {
        bottom constrainTo productPrice.top
        left constrainTo parent.left
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAndConstraintLayoutTheme {
        App()
    }
}



