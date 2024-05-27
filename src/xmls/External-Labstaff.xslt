<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Laboratory Staff</title>
      </head>
      <body>
        <h1>Laboratory staff's' Information</h1>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>name</th>
            <th>surname</th>
            <th>username</th>
          </tr>
          <xsl:for-each select="Obstetrician">
            <tr>
              <td><xsl:value-of select="id"/></td>
              <td><xsl:value-of select="name"/></td>
              <td><xsl:value-of select="surname"/></td>
              <td><xsl:value-of select="username"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
