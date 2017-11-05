# qmetric

In a working application the offer and product records would be stored
in a database. I'm mocking up some records here and populating them
as if they had been read in from a data store and formatted into objects

Setting up the offer objects:

An offer can be one of three types, mapped to the Unit enum.
WEIGHT:
The price for a product associated with this offer will be calculated based upon the
offer price divided product price

MULTIPLE:
The price for a product associated with this offer will be calculated based upon the product price x multiple price amount
Any left over products will be charged at standard product price

BULK:
The price for a product associated with this offer will be calculated based upon the 'Bulk purchase amount' of products = price
Any left over products will be charged at standard product price

Setting up the product objects:

The product object consists of an id, a name, a standard unit price/weight and an offer object (if applicable). If an offer is associated then it will be passed into the final price calculation, otherwise the standard product price will apply

Logic Flow: 

Once the product and offer objects have been created the 'addProductToOrder()' method is called for each item on the receipt. Each time a product is added to an order a check is made to see if we've got products on the ticket with this product's order. If not then we add the product's offer to a unique list of offers.

I then calculate any savings that the total amount of items on the receipt qualify for. I iterate over the unique list of offers that have been detected on the receipt, fetching all the products for each offer. I calculate the number of times the offer has been qualified for using the following algorithm:

(Assuming Beans are 3 for 2 and we've got 6 beans on the receipt)

(Offer Products(6) - (Offer Products(6) mod multiple purchase amount(3) = 0)) / multiple purchase amount(3)

Simplified: 
(6 - (6 mod 3)) / 3 = 2

So we know how many times to apply this saving to the receipt, now we just need to calculate the individual saving:

product price(0.50) x (multiple purchase amount(3) - multiple price amount(2))

Simplified:
0.50 x (3 - 2) = 0.50

Finally it's a case of multiplying this value by the number of times the offer has been qualified for. This gives us our total saving for this offer on the receipt. 

0.50 x 2 = 1.00

The offer object is sufficiently flexible to take a variable multiple purchase amount  and multiple price amount so is completely dynamic. Multiple versions of this class can be instantiated to represent different multiple purchase offers. 3 for 2, 6 for 4 etc. 

The same approach is taken for the bulk buy offer. The offer for the oranges by weight is the only place this model differs in that the price is calculated given the offer price (1.99) multiplied by the amount on the order.

I've taken this approach so during the output I can wind down the list of products on the order, in the order that they were added while building a list of savings objects. The individual products on the order allow me to easily build a sub total, then wind down the list of savings objects, creating a total amount value saved. Finally I can deduct the saving from the sub total to give an over total to pay.


