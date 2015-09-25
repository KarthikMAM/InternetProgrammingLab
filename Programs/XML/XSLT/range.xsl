<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Price</th>
                    </tr>
                    <xsl:for-each select="catalog/book">
                        <xsl:if test="not(price > 50) and (price > 10)">
                            <tr>
                                <td><xsl:value-of select="title"/></td>
                                <td><xsl:value-of select="price"/></td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
