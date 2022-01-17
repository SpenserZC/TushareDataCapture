from application import init_app

app = init_app("dev")

@app.route("/")
def index():
    return "index"

if __name__ == '__main__':
    app.run()