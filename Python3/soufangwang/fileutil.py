

def write(filename, content):
    fo = open(filename, 'w+', encoding="utf-8")
    fo.write(content)
    fo.close