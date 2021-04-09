'''import numpy as np
from flask import Flask, request, jsonify, render_template
import pickle

app = Flask(__name__)
model = pickle.load(open('model.pkl', 'rb'))

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/predict',methods=['POST'])
def predict():
    
    int_features = [int(x) for x in request.form.values()]
    final_features = [np.array(int_features)]
    prediction = model.predict(final_features)

    output = round(prediction[0], 2)

    return render_template('index.html', prediction_text='Employee Salary should be $ {}'.format(output))


if __name__ == "__main__":
    app.run(debug=True, use_reloader=False)'''
    
import numpy as np
import pandas as pd
from flask import Flask, request, jsonify, render_template
import pickle

app = Flask(__name__)
model = pickle.load(open('model23.pkl', 'rb'))

df = pd.read_csv('description_of_product_id.csv')

def predict1(model,listr):
  
    correlation_matrix = np.corrcoef(model)

    #i = "6117036094"
    i=listr[0]
    product_names = list(l)
    product_ID = product_names.index(i)


    correlation_product_ID = correlation_matrix[product_ID]
    Recommend=[]
    dic={}
    for k in range(len(l)):
        if(correlation_product_ID[k] > 0.90):
            Recommend.append(l[k])

    
    Recommend.remove(i) 
    
    '''for j in range(len(Recommend)):
        if(df.asin.isin([Recommend[i]])):
            dic[Recommend[i]]=df.image[i]'''
        
        

    return Recommend

@app.route('/')
def home():
    return jsonify({"messege":"Hi there"})

@app.route('/predict',methods=['POST'])
def predict():
    '''
    For rendering results on HTML GUI
    '''
    data=request.get_json(force=True)
    json=list(data.values())
    
    
    #final_features = [np.array(int_features)]
    prediction = predict1(model,json)
    
    dic={}
    dic["key"]=prediction
    return jsonify(dic)

    
    #return render_template('index.html', prediction_text='Different Product Id for the users will be {}'.format(prediction))

if __name__ == "__main__":
    app.run(debug=True,use_reloader=False)    
