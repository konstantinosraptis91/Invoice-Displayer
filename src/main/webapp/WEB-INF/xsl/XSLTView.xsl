<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Invoice Displayer</title>
                <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"/>
                <link rel="icon" href="resources/images/favicon.ico" type="image/x-icon"/>
            </head>
            <body>
                <center>
                    <table border="1">
                        <!-- header row -->
                        <tr>
                            <th>Customer</th>
                            <th>Order</th>
                            <th>Supplier</th>
                            <th>Transporter</th>
                        </tr>
                        <!-- 1st row -->
                        <tr>
                            <td>
                                <xsl:value-of select="invoice/customer/fullName"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/order/product"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/supplier/fullName"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/transporter/name"/>
                            </td>
                        </tr>
                        <!-- 2nd row -->
                        <tr>
                            <td>
                                <xsl:value-of select="invoice/customer/address"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/order/totalCost"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/supplier/address"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/transporter/address"/>
                            </td>
                        </tr>
                        <!-- 3rd row -->
                        <tr>
                            <td>
                                <xsl:value-of select="invoice/customer/phoneNumber"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/order/shippingDate"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/supplier/phoneNumber"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/transporter/phoneNumber"/>
                            </td>
                        </tr>
                        <!-- 4rth row -->
                        <tr>
                            <td>
                                <xsl:value-of select="invoice/customer/email"/>
                            </td>
                            <td/>
                            <td>
                                <xsl:value-of select="invoice/supplier/email"/>
                            </td>
                            <td>
                                <xsl:value-of select="invoice/transporter/email"/>
                            </td>
                        </tr>
                    </table>
                </center>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>