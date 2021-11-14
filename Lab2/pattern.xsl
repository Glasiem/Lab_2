<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/articles">
        <html>
            <body>
                <table border="1">
                    <tr>
                        <th>Title</th>
                        <th>Annotation</th>
                        <th>Author</th>
                        <th>Location</th>
                        <th>Review</th>
                    </tr>
                    <xsl:for-each select="article">
                        <tr>
                            <td>
                                <xsl:value-of select="title" />
                            </td>
                            <td>
                                <xsl:value-of select="annotation" />
                            </td>
                            <td>
                                <xsl:value-of select="author" />
                            </td>
                            <td>
                                <xsl:value-of select="location" />
                            </td>
                            <td>
                                <xsl:value-of select="review" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>