

def write(filename, content):
    fo = open(filename, 'w+', encoding="utf-8")
    fo.write(content)
    fo.close()

def read(filename):
    fo = open(filename, 'r+', encoding="utf-8")
    content = fo.read()
    fo.close()
    return content

def append(filename, content):
    fo = open(filename, 'a+', encoding="utf-8")
    fo.write(content)
    fo.close()